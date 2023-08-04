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
  <NuxtLayout name="custom">
    <h1 class="text-xl">Webshop Home Page</h1>
  </NuxtLayout>
</template>

<style scoped></style>
