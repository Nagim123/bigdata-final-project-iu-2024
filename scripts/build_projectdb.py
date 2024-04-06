import psycopg2 as psql
from pprint import pprint
import os


# Read password from secrets file
file = os.path.join("secrets", ".psql.pass")
with open(file, "r") as file:
    password = file.read().rstrip()

# build connection string
conn_string = f"host=hadoop-04.uni.innopolis.ru port=5432 user=team14 \
    dbname=team14_projectdb password={password}"


# Connect to the remote dbms
with psql.connect(conn_string) as conn:
    # Create a cursor for executing psql commands
    cur = conn.cursor()
    # Read the commands from the file and execute them.
    with open(os.path.join("sql", "create_tables.sql")) as file:
        content = file.read()
        cur.execute(content)
    conn.commit()

    # Read the commands from the file and execute them.
    with open(os.path.join("sql", "import_data.sql")) as file:
        commands = file.readlines()
        with open(os.path.join("data", "houses.csv"), "r") as houses:
            cur.copy_expert(commands[0], houses)
        with open(os.path.join("data", "real_estate_announcements.csv"),
                  "r") as real_esate_announcements:
            cur.copy_expert(commands[1],  real_esate_announcements)

    # If the sql statements are CRUD then you need to commit the change
    conn.commit()

    pprint(conn)
    cur = conn.cursor()
    # Read the sql commands from the file
    with open(os.path.join("sql", "test_database.sql")) as file:
        commands = file.readlines()
        for command in commands:
            cur.execute(command)
            # Read all records and print them
            pprint(cur.fetchall())