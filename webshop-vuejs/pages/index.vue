<script setup lang="ts">
const title = ref('Webshop');
const description = ref('Webshop');

useHead({
  title: 'Home page',
  meta: [
    {
      hid: 'description',
      name: 'description',
      content: 'Description Here',
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
