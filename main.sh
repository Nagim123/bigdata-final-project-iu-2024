#!/bin/sh


# Run the big data pipeline
bash scripts/run.sh


# Check the quality of the codes
echo "The quality of scripts in 'scripts/' folder\n"
echo "::============================================::"
pylint scripts


echo "The quality of scripts in 'notebooks/' folder"
echo "::============================================::"
pylint notebooks



echo "Done testing the pipeline!"