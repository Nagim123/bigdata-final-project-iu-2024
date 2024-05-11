#!/bin/bash
url="https://disk.yandex.ru/d/id7hhPrw6iQGKw"

rm -f data/data.zip
rm -f data/input_data.csv
rm -f data/houses.csv
rm -f data/real_estate_announcements.csv

wget "$(yadisk-direct $url)" -O data/data.zip

unzip data/data.zip -d data/

rm data/data.zip

python scripts/preprocessor.py