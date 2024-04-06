#!/bin/bash
url="https://disk.yandex.ru/d/my_0uAdlNo2BxA"

rm -f data/data.zip
rm -f data/houses.csv
rm -f data/real_estate_announcements.csv

wget "$(yadisk-direct $url)" -O data/data.zip

unzip data/data.zip -d data/

rm data/data.zip