# 4-Spring/13-Recap-Project/Todo - Backend

## Setup: Download frontend

Today we will focus on the ToDo backend. Follow the steps to complete the task.

1. Download the [frontend](https://github.com/neuefische/java-todo-frontend/releases/download/v1.0.0/frontend.zip)
2. Create a Spring Boot project in Intellij and add the necessary dependencies directly (e.g., Spring Web and Lombok)
3. Copy the contents of `frontend.zip` into the following directory: `src/main/resources/static`

   ![Image of how it should look](https://abload.de/img/imgcmdql.png)
4. Start the backend -> the frontend should now be visible at `localhost:8080`!

What is the GitHub repo you are working on together?

`inputfield`

## Research: Analyze accesses

Use the developer tools in your browser (the "Network" tab) to analyze the accesses of the frontend. Which endpoints are being addressed (URLs and HTTP methods)? What data is being sent to the server?

## Coding: Develop backend

Implement the HTTP endpoints that your frontend needs.
Go through the endpoints step by step and also write tests for your methods.


## Bonus: ChatGPT API

Let ChatGPT perform a spelling and grammar correction of the ticket texts for each new ToDo item.

Also, write integration tests for this (mock ChatGPT with MockWebServer!).

## Bonus: Monitoring

Add a current dependency to `JavaMelody` to your backend. Your backend should now display a dashboard at `/monitoring` that provides information about the performance of your backend.

Click around in the frontend a few times and check the metrics of your backend.

Can you imagine a situation where monitoring your backend could be helpful?
`inputfield`

## Bonus: ChatGPT initialization

Write a new endpoint "POST /initialize/{topic}" to generate approximately 20-30 new todo items from the ChatGPT API.

Also, write integration tests here (mocking ChatGPT with MockWebServer!).

## Bonus: Undo Endpoint

Implement an HTTP endpoint in the backend at `/undo` that undoes the last change.

No adjustments are necessary in the frontend. Simply call the endpoint via Postman and check if the last change was undone.

Write good integration tests for this endpoint.

It should also be possible to call the endpoint multiple times to undo multiple changes.

## Bonus: Redo Endpoint

Now, also write a `/redo` endpoint to undo a previous undo.
