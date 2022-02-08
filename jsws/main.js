const http = require("http");
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
  res.setHeader("Connection", "keep-alive");
  res.writeHead(200); // 200 OK
  res.end("Hello"); // send data to client side
};