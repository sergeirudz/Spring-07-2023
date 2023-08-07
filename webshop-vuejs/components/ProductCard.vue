<template lang="">
  <div class="w-64 p-2 m-auto bg-white shadow-lg rounded-2xl">
    <!-- src="https://placehold.co/200" -->
    <img
      :src="data.thumbnail"
      alt="product name"
      class="w-22 p-2 m-auto h-40"
    />

    <div class="p-3 m-2 bg-gray-600 rounded-lg">
      <h3 class="text-xl font-bold text-white">{{ data.title }}</h3>
      <h4 class="text-xs text-white mb-2">
        {{ data.category.toUpperCase() }}
      </h4>
      <p class="text-xs text-gray-50">{{ data.description }}</p>

      <div class="flex items-center justify-between">
        <p class="text-white">$ {{ data.price }}</p>
        <div class="flex items-center justify-between flex-col mt-2 gap-2">
          <p class="text-xs text-gray-50 text-left">Add To Cart</p>
          <NuxtLink
            :to="`/products/${data.id}`"
            class="text-xs text-gray-50 text-left"
            >Read More</NuxtLink
          >
        </div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts">
import { Product } from 'types/models/Product';

import { defineComponent } from 'vue';
import type { PropType } from 'vue';

defineProps<{
  data: PropType<Product>;
}>();
</script>
<style lang=""></style>
