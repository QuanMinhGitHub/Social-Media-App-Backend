# Facebook-like App API Documentation

## Authentication

### Sign-Up
- **Endpoint**: `POST /api/auth/sign-up`

- **Payload**:
    ```json
    {
      "firstname": "string",
      "lastname": "string",
      "email": "string",
      "password": "string"
    }

- **Response**:
    ```json
    {
      "message": "Registered successfully"
    }

### Sign-In
- **Endpoint**: `POST /api/auth/sign-in`

- **Payload**:
    ```json
    {
      "email": "string",
      "password": "string"
    }

- **Response**:
    ```json
    {
      "message": "Sign in successfully",
      "token": "string"
    }

## Avatar Management

### Upload/Update Avatar
- **Endpoint**: `PUT /api/avatar`

- **Headers**:
    ```json
    {
      "Authorization": "Bearer <token>"
    }

- **Payload**:
    ```json
    {
      "avatar": "string"
    }

- **Response**:
    ```json
    {
      "message": "Avatar updated successfully",
      "avatar": "url"
    }

## Post Management

### Get Posts
- **Endpoint**: `GET /api/posts`

- **Response**:
    ```json
    [
      {
        "id": "integer",
        "firstname": "string",
        "lastname": "string",
        "content": "string",
        "image": "string (optional)",
        "likeCount": "integer",
        "commentCount": "integer"
      }
    ]

### Create Post
- **Endpoint**: `POST /api/posts/create-post`

- **Headers**:
    ```json
    {
      "Authorization": "Bearer <token>"
    }

- **Payload**:
    ```json
    {
      "content": "string",
      "image": "string (optional)"
    }

- **Response**:
    ```json
    {
      "message": "Post created successfully"
    }

## Post Engagement

### Like Post
- **Endpoint**: `POST /api/posts/like`

- **Headers**:
    ```json
    {
      "Authorization": "Bearer <token>"
    }

- **Response**:
    ```json
    {
      "likeCount": "integer"
    }

### Comment on Post
- **Endpoint**: `POST /api/posts/comment`

- **Headers**:
    ```json
    {
      "Authorization": "Bearer <token>"
    }

- **Payload**:
    ```json
    {
      "content": "string"
    }

- **Response**:
    ```json
    {
      "commentCount": "integer"
    }
