<script setup lang="ts">
// import {} from "#app";
const route = useRoute();
const name = route.params.name;
const product = true;
// const product = // TODO: fetch product by name

useMeta({
  title: true ? name : '404 - Product Not Found',
  meta: [
    {
      name: 'viewport',
      content: 'width=device-width',
    },
  ],
});
</script>

<template>
  <div>
    <NuxtLayout name="custom" v-if="product">
      <div class="">PRODUCT INFO HERE</div>
    </NuxtLayout>

    <div class="" v-else>
      <NuxtLayout name="error">
        <template #header>
          <h1>Product not found</h1>
        </template>
        <template #redirectEl>
          <button class="" @click="$router.push('/products')">Go Back</button>
          <NuxtLink to="/products">Go Back</NuxtLink>
        </template>
      </NuxtLayout>
    </div>
  </div>
</template>
