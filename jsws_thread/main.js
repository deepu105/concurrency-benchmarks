const http = require("http");
const fs = require("fs").promises;
const cluster = require("cluster");
const numCPUs = require("os").cpus().length;

let count = 0;

// set router
const server = http.createServer((req, res) => {
  count++;
  requestListener(req, res, count);
});

const host = "localhost";
const port = 8080;

if (cluster.isMaster) {
  console.log(`Master ${process.pid} is running`);

  // Fork workers.
  for (let i = 0; i < numCPUs; i++) {
    cluster.fork();
  }

  cluster.on("exit", (worker, code, signal) => {
    console.log(`worker ${worker.process.pid} died`);
  });
} else {
  // set listen port, TCP connection is shared by all workers
  server.listen(port, host, () => {
    console.log(
      `Worker ${process.pid}: Server is running on http://${host}:${port}`
    );
  });
}

const requestListener = async function (req, res, count) {
  // add 2 second delay to every 10th request
  if (count % 10 === 0) {
    console.log("Adding delay. Count: ", count);
    await sleep(2000);
  }
  const contents = await fs.readFile(__dirname + "/hello.html"); // read html file
  res.setHeader("Connection", "keep-alive");
  res.writeHead(200); // 200 OK
  res.end(contents); // send data to client side
};

// sleep function since NodeJS doesn't provide one
function sleep(ms) {
  return new Promise((resolve) => {
    setTimeout(resolve, ms);
  });
}
