#!/bin/bash


# Run the big data pipeline
echo "Running Stage 1 of the pipeline"
bash scripts/stage1.sh

echo "Running Stage 2 of the pipeline"
bash scripts/stage2.sh

echo "Running Stage 3 of the pipeline"
bash scripts/stage3.sh

echo "Running Stage 4 of the pipeline"
bash scripts/stage4.sh

echo "Running Stage 5 of the pipeline"
bash scripts/stage5.sh


#bash scripts/run.sh


# Check the quality of the codes
echo "The quality of scripts in 'scripts/' folder\n"
echo "::============================================::"
pylint scripts


echo "Done testing the pipeline!"
