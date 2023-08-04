<script setup lang="ts">
const title = ref('Webshop');
const description = ref('Webshop');

useHead({
  title,
  htmlAttrs: {
    lang: 'en',
  },
  meta: [
    {
      name: 'description',
      content: description,
    },
  ],
});
</script>

<template>
  <div>
    <div class="container">
      <h1>Webshop</h1>
      <NuxtLink to="/products">View Products</NuxtLink>
    </div>
  </div>
</template>

<style scoped>
.container {
  text-align: center;
  margin-top: 5rem;
}
</style>
