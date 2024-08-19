Github user bridge

Project is written using JDK 22.01
to run tests and build, use 'mvn clean install'
after running the application, the endpoint for fetching used details is exposed under:

(GET) http://localhost:8080/users/{user_login}

for example:

(GET) http://localhost:8080/users/octocat

example response:

{
    "id": "583231",
    "login": "octocat",
    "name": "The Octocat",
    "type": "User",
    "avatarUrl": "https://avatars.githubusercontent.com/u/583231?v=4",
    "createdAt": "2011-01-25T18:44:36Z",
    "calculations": 0.004113252
}

example CURL:

curl --request GET http://localhost:8080/users/octocat