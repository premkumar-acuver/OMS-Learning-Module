create table users(
id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
name VARCHAR(20) NOT NULL,
email VARCHAR(20) UNIQUE NOT NULL
)