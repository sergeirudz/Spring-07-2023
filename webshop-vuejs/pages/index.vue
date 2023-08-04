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
  <div class="">
    <div class="">
      <h1 class="text-xl">Webshop</h1>
      <NuxtLink to="/products">View Products</NuxtLink>
    </div>
  </div>
</template>

<style scoped></style>
