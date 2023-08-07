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
        <button
          type="button"
          class="w-10 h-10 text-base font-medium text-white bg-pink-500 rounded-full hover:bg-pink-700"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            class="mx-auto"
            fill="white"
            viewBox="0 0 1792 1792"
          >
            <path
              d="M1600 736v192q0 40-28 68t-68 28h-416v416q0 40-28 68t-68 28h-192q-40 0-68-28t-28-68v-416h-416q-40 0-68-28t-28-68v-192q0-40 28-68t68-28h416v-416q0-40 28-68t68-28h192q40 0 68 28t28 68v416h416q40 0 68 28t28 68z"
            ></path>
          </svg>
        </button>
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
