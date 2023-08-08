<template>
    <NuxtLayout name="custom">
        <h1 class="text-xl">Cart Page</h1>

        <table>
            <thead>
                <tr>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(item, index) in cartStore.cartItems" :key="index">
                    <td class="text-center">
                        <img class="m-auto" height="100" width="100" :src="item.thumbnail" alt="" />
                    </td>
                    <td class="text-center">{{ item.title }}</td>
                    <td class="text-center">${{ item.price }}</td>
                    <td class="text-center">
                        <span class="flex gap-3 select-none">
                            <span @click="handleRemoveOneFromCart(item)">-</span>
                            {{ item.nrInCart }}
                            <span @click="handleAddOneToCart(item)">+</span>
                            <span></span>
                        </span>
                    </td>
                    <td class="text-center">
                        <span>{{ item.price * item.nrInCart! }}</span>
                    </td>
                    <td class="text-center">
                        <button @click="handleRemoveFromCart(item)">Remove</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </NuxtLayout>
</template>
<script setup lang="ts">
import { useCartStore } from "store/store.cart";
import { Product } from "types/models/Product";

const cartStore = useCartStore();
const isStoreInitialized = ref(false);
const cartMap = new Map();

onMounted(() => {
    if (cartStore.$state) {
        isStoreInitialized.value = true;

        cartStore.cartItems.forEach((item) => {
            if (cartMap.has(item)) {
                cartMap.set(item, cartMap.get(item) + 1);
            } else {
                cartMap.set(item, 1);
            }
        });
    }
});

// const handleAddOneToCart = (product: Product) => {
//     cartStore.addOneToCart(product);
// };
// const handleRemoveFromCart = (product: Product) => {
//     cartStore.removeOneFromCart(product);
// };
const nrProductsAddedToCart = computed(() => {
    return cartStore.cartItems.length;
});

const handleRemoveOneFromCart = (product: Product) => {
    if (cartMap.has(product)) {
        cartMap.set(product, cartMap.get(product) - 1);
    }
    cartStore.removeOneFromCart(product);
};

const handleAddOneToCart = (product: Product) => {
    if (cartMap.has(product)) {
        cartMap.set(product, cartMap.get(product) + 1);
    }
    cartStore.addOneToCart(product);
};

const handleRemoveFromCart = (product: Product) => {
    if (cartMap.has(product)) {
        cartMap.set(product, 0);
    }
    cartStore.deleteProductFromCart(product);
};

definePageMeta({
    middleware: ["user-only"],
});

useHead({
    title: "Cart Page",
    meta: [
        {
            hid: "description",
            name: "description",
            content: "Description Here",
        },
    ],
});
</script>
<style lang=""></style>
