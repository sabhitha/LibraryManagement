# LibraryManagement
Library system to manage inventory and patrons

Library management contains following packages
- Books
    - To manage(add/update/delete) books and inventory
- Library
    - To manage book lending and returning book by user
- Users
    - To add and manage users and there Membership with Library
 

Class wise details:
Books class is for adding Books with details
Inventory class is to add /remove /update books to library
Users class is to uniquely identify user
Membership classes manages to add users into library and track books lent by users
Driver classes populate with books in start of application and functions to prompt user with inputs


Additional enhancements(to-do):

1. Library interface can be created so that it can be implemented in mutiple Branch Libraries
2. Users class can be extended to use LibraryUsers and LibraryMembers so that only LibraryMembers can access inventory to update book details in bulk
3. Recomendation for the users based on their history
4. Display Top 5/10 books lent by user

