const http = require("http");
const fs = require("fs").promises;

// set router
const server = http.createServer((req, res) => {
  requestListener(req, res);
});

const host = "localhost";
const port = 8080;

// set listen port
server.listen(port, host, () => {
  console.log(`Server is running on http://${host}:${port}`);
});

const requestListener = async function (req, res) {
  const contents = await fs.readFile(__dirname + "/hello.html"); // read html file
  res.setHeader("Connection", "keep-alive");
  res.writeHead(200); // 200 OK
  res.end(contents); // send data to client side
};