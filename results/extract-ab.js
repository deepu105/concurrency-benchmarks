const extractor = require("file-extractor");
const fs = require("fs");

console.log(`Reading file: ${__dirname}/${process.argv[2]}\n`);
const s = fs.createReadStream(`${__dirname}/${process.argv[2]}`, {});

let noOfRuns = 0;
let timeTaken = 0;
let reqPerSec = 0;
let timePerReq = 0;
let timePerReqAcc = 0;
let transferRate = 0;
let bestTimeTaken = 1000000;
let bestReqPerSec = 0;
let bestTimePerReq = 1000000;
let bestTimePerReqAcc = 100000;
let bestTransferRate = 0;

extractor()
  .matches(/Time taken for tests:\s*([0-9.]*) seconds/, (m) => {
    noOfRuns++;
    timeTaken += parseFloat(m[1]);
    bestTimeTaken = Math.min(bestTimeTaken, parseFloat(m[1]));
  })
  .on("end", () => {
    timeTaken = timeTaken / noOfRuns;
    console.log(`Avg Time Taken: ${timeTaken}`);
  })
  .start(s);

extractor()
  .matches(/Requests per second:\s*([0-9.]*)/, (m) => {
    reqPerSec += parseFloat(m[1]);
    bestReqPerSec = Math.max(bestReqPerSec, parseFloat(m[1]));
  })
  .on("end", () => {
    reqPerSec = reqPerSec / noOfRuns;
    console.log(`Avg Requests Per Sec: ${reqPerSec}`);
  })
  .start(s);

extractor()
  .matches(/Time per request:\s*([0-9.]*) \[ms\] \(mean\)/, (m) => {
    timePerReq += parseFloat(m[1]);
    bestTimePerReq = Math.min(bestTimePerReq, parseFloat(m[1]));
  })
  .on("end", () => {
    timePerReq = timePerReq / noOfRuns;
    console.log(`Avg Time Per Req: ${timePerReq}`);
  })
  .start(s);

extractor()
  .matches(
    /Time per request:\s*([0-9.]*) \[ms\] \(mean, across all concurrent requests\)/,
    (m) => {
      timePerReqAcc += parseFloat(m[1]);
      bestTimePerReqAcc = Math.min(bestTimePerReqAcc, parseFloat(m[1]));
    }
  )
  .on("end", () => {
    timePerReqAcc = timePerReqAcc / noOfRuns;
    console.log(`Avg Time Per Req Across: ${timePerReqAcc}`);
  })
  .start(s);

extractor()
  .matches(/Transfer rate:\s*([0-9.]*)/, (m) => {
    transferRate += parseFloat(m[1]);
    bestTransferRate = Math.max(bestTransferRate, parseFloat(m[1]));
  })
  .on("end", () => {
    transferRate = transferRate / noOfRuns;
    console.log(`Avg TransferRate: ${transferRate}`);
    console.log(`CSV Avg values`);
    console.log(
      `\n${timeTaken}, ${reqPerSec}, ${timePerReq}, ${timePerReqAcc}, ${transferRate}\n`
    );
    console.log(`CSV best values`);
    console.log(
      `\n${bestTimeTaken}, ${bestReqPerSec}, ${bestTimePerReq}, ${bestTimePerReqAcc}, ${bestTransferRate}\n`
    );
  })
  .start(s);
