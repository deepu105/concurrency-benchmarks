import { serve } from "https://deno.land/std/http/server.ts";

const handleRequest = async (request: Request): Promise<Response> => {
  // read html file
  const res = {
    status: 200,
    headers: new Headers(),
  };
  res.headers.set("Connection", "keep-alive");
  return new Response("Hello", res); // send data to client side
};

// set listen port and listen to all incoming requests
await serve(handleRequest, { hostname: "0.0.0.0", port: 8080 });
console.log(`HTTP webserver running at:  http://localhost:8080/`);
