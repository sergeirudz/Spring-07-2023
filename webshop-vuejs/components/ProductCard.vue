<template lang="">
    <div class="w-64 p-2 m-auto bg-white shadow-lg rounded-2xl" v-if="isStoreInitialized">
        <!-- src="https://placehold.co/200" -->
        <img :src="data.thumbnail" alt="product name" class="w-22 p-2 m-auto h-40" />

        <div class="p-3 m-2 bg-gray-600 rounded-lg">
            <span class="flex justify-between">
                <span>
                    <h3 class="text-xl font-bold text-white">{{ data.title }}</h3>
                    <h4 class="text-xs text-white mb-2">
                        {{ data.category.toUpperCase() }}
                    </h4>
                </span>
                <span
                    :class="
                        (nrProductsAddedToCart <= 0 && 'hidden') || (nrProductsAddedToCart === undefined && 'hidden')
                    "
                    class="text-xl flex gap-3 select-none"
                >
                    <span @click="handleRemoveFromCart(data)" class="cursor-pointer text-gray-50">-</span>
                    <span class="text-red-600">{{ nrProductsAddedToCart }}</span>
                    <span @click="handleAddToCart(data)" class="cursor-pointer text-gray-50">+</span>
                </span>
            </span>
            <p class="text-xs text-gray-50">{{ data.description }}</p>

            <div class="flex items-center justify-between">
                <p class="text-white">$ {{ data.price }}</p>
                <div class="flex items-center justify-between flex-col mt-2 gap-2">
                    <button class="text-xs text-gray-50 text-left" @click="handleAddToCart(data)">Add To Cart</button>

                    <NuxtLink :to="`/products/${data.id}`" class="text-xs text-gray-50 text-left">Read More</NuxtLink>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup lang="ts">
import { Product } from "types/models/Product";
import { useCartStore } from "store/store.cart";
import { computed } from "vue";
const props = defineProps<{
    data: Product;
}>();

const cartStore = useCartStore();
const handleAddToCart = (product: Product) => {
    cartStore.addToCart(product);
};
const handleRemoveFromCart = (product: Product) => {
    cartStore.removeFromCart(product);
};
const nrProductsAddedToCart = computed(() => {
    return cartStore.cartItems.find((item) => item.id === props.data.id)?.nrInCart;
});

const isStoreInitialized = ref(false);
onMounted(() => {
    if (cartStore.$state) {
        isStoreInitialized.value = true;
    }
});
</script>
<style lang=""></style>
