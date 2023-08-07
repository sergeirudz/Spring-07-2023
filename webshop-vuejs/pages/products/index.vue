<script setup lang="ts">
definePageMeta({
    middleware: ["user-only"],
});

const {
    data: products,
    error,
    refresh,
    pending,
} = useAsyncData("products", async () => {
    const { data } = await useFetch<any>("/api/products"); // TODO: response type
    return data.value;
});

useHead({
    title: "All Products",
    meta: [
        {
            hid: "description",
            name: "description",
            content: "All Products",
        },
    ],
});
</script>

<template>
    <div v-if="!pending">
        <NuxtLayout name="custom">
            <h1 class="text-xl">Products List Page</h1>
            <div v-if="pending">
                <h2>Loading...</h2>
            </div>
            <div v-if="error">
                <h2>Error: {{ error.message }}</h2>
            </div>
            <div class="flex gap-1 flex-wrap">
                <ProductCard v-for="(product, index) in products" :key="index" :data="product" />
            </div>
        </NuxtLayout>
    </div>
</template>
