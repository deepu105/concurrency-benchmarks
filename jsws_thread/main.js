const http = require("http");
const fs = require("fs").promises;
const cluster = require("cluster");
const numCPUs = require("os").cpus().length;

// set router
const server = http.createServer((req, res) => {
  requestListener(req, res);
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

const requestListener = async function (req, res) {
  const contents = await fs.readFile(__dirname + "/hello.html"); // read html file
  res.setHeader("Connection", "keep-alive");
  res.writeHead(200); // 200 OK
  res.end(contents); // send data to client side
};