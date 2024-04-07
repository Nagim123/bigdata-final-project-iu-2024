#!/bin/bash
url="https://disk.yandex.ru/d/ais0k8YpTotFpQ"

rm -f data/data.zip
rm -f data/houses.csv
rm -f data/real_estate_announcements.csv

wget "$(yadisk-direct $url)" -O data/data.zip

unzip data/data.zip -d data/

rm data/data.zip

echo "building database... (please wait)"
python3 scripts/build_projectdb.py