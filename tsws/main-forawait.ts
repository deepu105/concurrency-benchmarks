import { serve } from "https://deno.land/std/http/server.ts";

let count = 0;

// set listen port
const server = serve({ hostname: "0.0.0.0", port: 8080 });
console.log(`HTTP webserver running.  Access it at:  http://localhost:8080/`);

for (const request of server) {
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
  await request.respond(res);
}

function sleep(ms: number) {
  return new Promise((resolve) => {
    setTimeout(resolve, ms);
  });
}
