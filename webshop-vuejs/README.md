# Webshop Client - Vue/Nuxt

## Pages to create

- Public routes
  - /                       redirect to /login or /products
  - /login                  Login page
  - /register               Register page
  - /forgot-password        Forgot password
  - /reset-password         Reset password

- User routes
  - /products               display all products
  - /cart                   all products in cart
  - /pay                    purchase product
  - /profile                edit personal profile

- Admin routes
  - /edit-products          List of all products
  - /edit-products/:id      Edit one product
  - /edit-categories        List of all categories
  - /edit-categories/:id    Edit one category
  - /users                  Edit Users & Admins
  - /users/:id              Edit one user

## Application Requirements

- TailwindCSS
  - <https://www.tailwind-kit.com/> <----- SELECTED
  - <https://www.vue-tailwind.com/docs/installation>
  - <https://tailwind-elements.com/docs/standard/integrations/vue-integration/>
  - <https://merakiui.com/components>
- Pinia state management <https://pinia.vuejs.org/>

## Examples

- Storybook <https://github.dev/srcdev/nuxt3-pinia-i18n-storybook/tree/main/stores>
- Middleware <https://github.dev/damien-hl/nuxt3-auth-example/tree/main/middleware>
