const http = require("http");
const fs = require("fs").promises;

let count = 0;

// set router
const server = http.createServer((req, res) => {
  count++;
  requestListener(req, res, count);
});

const host = "localhost";
const port = 8080;

// set listen port
server.listen(port, host, () => {
  console.log(`Server is running on http://${host}:${port}`);
});

const requestListener = async function (req, res, count) {
  // add 2 second delay to every 10th request
  if (count % 10 === 0) {
    console.log("Adding delay. Count: ", count);
    await sleep(2000);
  }
  const contents = await fs.readFile(__dirname + "/hello.html"); // read html file
  res.writeHead(200); // 200 OK
  res.end(contents); // send data to client side
};

function sleep(ms) {
  return new Promise((resolve) => {
    setTimeout(resolve, ms);
  });
}
