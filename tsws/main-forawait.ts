import { serve, ServerRequest } from "https://deno.land/std/http/server.ts";

let count = 0;

// set listen port
const server = serve({ hostname: "0.0.0.0", port: 8080 });
console.log(`HTTP webserver running at:  http://localhost:8080/`);

// listen to all incoming requests
for await (const request of server) handleRequest(request);

async function handleRequest(request: ServerRequest) {
  count++;
  // add 2 second delay to every 10th request
  if (count % 10 === 0) {
    console.log("Adding delay. Count: ", count);
    await sleep(2000);
  }
  // read html file
  const body = await Deno.readTextFile("./hello.html");
  const res = {
    status: 200,
    body,
    headers: new Headers(),
  };
  res.headers.set("Connection", "keep-alive");
  request.respond(res); // send data to client side
}

// sleep function since NodeJS doesn't provide one
function sleep(ms: number) {
  return new Promise((resolve) => {
    setTimeout(resolve, ms);
  });
}
