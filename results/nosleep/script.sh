#!/bin/bash

echo "===================== Running wrk  benchmark ====================="

echo "## $1" >>  wrk.md

echo "\`\`\`" >>  wrk.md
wrk -t8 -c500 -d30s http://127.0.0.1:8080 >> wrk.md
echo "\`\`\`" >>  wrk.md

echo "=================================================================="

read -p "Press [Enter] key to start next benchmark..."

echo "================== Running drill benchmark 1 ====================="

echo "## $1" >>  drill-benchmark-1.md

echo "\`\`\`" >>  drill-benchmark-1.md
drill --benchmark benchmark-1.yml --stats -q >> drill-benchmark-1.md
echo "\`\`\`" >>  drill-benchmark-1.md

echo "=================================================================="

read -p "Press [Enter] key to start next benchmark..."

echo "================== Running drill benchmark 2 ====================="

echo "## $1" >>  drill-benchmark-2.md

echo "\`\`\`" >>  drill-benchmark-2.md
drill --benchmark benchmark-2.yml --stats -q >> drill-benchmark-2.md
echo "\`\`\`" >>  drill-benchmark-2.md

echo "=================================================================="