<template lang="">
  <NuxtLayout name="default">
    <div>Add Product</div>
  </NuxtLayout>
</template>
<script setup lang="ts">
definePageMeta({
  middleware: ['admin-only'],
});
</script>
<style lang=""></style>
