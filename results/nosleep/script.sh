#!/bin/bash

echo "===================== Running wrk  benchmark ====================="

echo "## $1" >>  wrk-taskset.md

echo "\`\`\`" >>  wrk-taskset.md
taskset --cpu-list 8-15 wrk -t8 -c500 -d30s http://127.0.0.1:8080 >> wrk-taskset.md
echo "\`\`\`" >>  wrk-taskset.md

echo "=================================================================="

read -p "Press [Enter] key to start next benchmark..."

echo "================== Running drill benchmark 1 ====================="

echo "## $1" >>  drill-benchmark-1-taskset.md

echo "\`\`\`" >>  drill-benchmark-1-taskset.md
taskset --cpu-list 8-15 drill --benchmark benchmark-1.yml --stats -q >> drill-benchmark-1-taskset.md
echo "\`\`\`" >>  drill-benchmark-1-taskset.md

echo "=================================================================="

read -p "Press [Enter] key to start next benchmark..."

echo "================== Running drill benchmark 2 ====================="

echo "## $1" >>  drill-benchmark-2-taskset.md

echo "\`\`\`" >>  drill-benchmark-2-taskset.md
taskset --cpu-list 8-15 drill --benchmark benchmark-2.yml --stats -q >> drill-benchmark-2-taskset.md
echo "\`\`\`" >>  drill-benchmark-2-taskset.md

echo "=================================================================="