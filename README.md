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
      "message": "Registered successfully",
      "token": "string"
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
        "firstname": "string",
        "lastname": "string",
        "content": "string",
        "image": "string (optional)",
        "likeCount": "integer",
        "commentCount": "integer",
        "createdAt": "string"
      }
    ]

### Create Post
- **Endpoint**: `POST /api/posts`

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

### Update Post
- **Endpoint**: `PUT /api/posts/{postId}`

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
      "message": "Post updated successfully",
      "content": "string",
      "image": "string (optional)"
    }

### Delete Post
- **Endpoint**: `DELETE /api/posts/{postId}`

- **Headers**:
    ```json
    {
      "Authorization": "Bearer <token>"
    }

- **Response**:
    ```json
    {
      "message": "Post deleted successfully"
    }

## Post Engagement

### Like Post
- **Endpoint**: `POST /api/posts/{postId}/like`

- **Headers**:
    ```json
    {
      "Authorization": "Bearer <token>"
    }

- **Response**:
    ```json
    {
      "message": "Post liked successfully",
      "likeCount": "integer"
    }

### Comment on Post
- **Endpoint**: `POST /api/posts/{postId}/comment`

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
      "message": "Comment added successfully",
      "content": "string",
      "commentCount": "integer"
    }
