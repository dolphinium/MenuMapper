# MenuMapper: Mapping Café Experiences

> Revolutionizing the way users interact with coffee menus.

## Vision Statement

Our objective is to create a dynamic app that facilitates menu exploration while enhancing the overall customer experience at cafés. By bridging the gap between customers and cafés, we aim to promote a vibrant ecosystem that benefits both parties.

## Endpoints

### Authentication

- **POST /api/auth/signin:** Authenticates the user and returns a JWT token.
- **POST /api/auth/signup:** Registers a new user.

### Café Management

- **POST /api/add/cafe:** Adds a new café.
- **GET /api/findAll/cafe:** Retrieves all cafés.
- **DELETE /api/delete/cafe/{cafeName}:** Deletes a café by name.
- **GET /api/get/cafeWithName/{cafeName}:** Retrieves a café by name.
- **GET /api/get/cafeWithAddress/{lon}/{lat}:** Retrieves cafés by address.
- **PUT /api/update/cafe:** Updates café details.

### Comments

- **GET /api/get/comments:** Retrieves all comments.
- **GET /api/get/averageStars/{cafeId}:** Retrieves average star rating for a café.
- **GET /api/get/commentsWithCafeId/{cafeId}:** Retrieves comments for a specific café.
- **POST /api/add/comment:** Adds a new comment.
- **DELETE /api/delete/comment/{commentId}:** Deletes a comment by ID.
- **PUT /api/update/comment:** Updates a comment.

### Menu Items

- **POST /api/add/menuItem:** Adds a new menu item.
- **GET /api/findAll/menuItemWithName/{menuItemName}/{asc}:** Retrieves menu items by name, sorted by price.
- **GET /api/findAll/menuItemWithCategory/{categoryName}:** Retrieves menu items by category.
- **GET /api/findAll/menuItemWithCafeName/{cafeName}:** Retrieves menu items by café.
- **DELETE /api/delete/menuItem/{menuItemName}:** Deletes a menu item by name.
- **PUT /api/update/menuItem:** Updates a menu item.

### Users

- **GET /api/get/users:** Retrieves all users.
- **GET /api/get/userWithId/{id}:** Retrieves a user by ID.
- **POST /api/add/user:** Adds a new user.
- **DELETE /api/delete/user/{phoneNumber}:** Deletes a user by phone number.
- **GET /api/get/userWithPhoneNumber/{phoneNumber}:** Retrieves a user by phone number.
- **PUT /api/update/user:** Updates a user.


## Database

The application uses MongoDB to store data. The key collections are:

1. **Users:** Stores user information including username, email, password (hashed), and roles.
2. **Roles:** Stores role information such as `ROLE_USER`, `ROLE_ADMIN`, and `ROLE_CAFE_HOLDER`.
3. **Cafés:** Stores information about cafés including name, address, and menu items.
4. **Comments:** Stores user comments and ratings for cafés.
5. **MenuItems:** Stores details about menu items available at various cafés.

## JWT Token Implementation

### Overview

JWT (JSON Web Token) is used for securing the API endpoints. The tokens are generated upon successful authentication and include user details and roles.

### Token Generation

The token is generated in the `AuthController`