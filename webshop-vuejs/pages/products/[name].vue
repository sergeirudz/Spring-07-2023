<script setup lang="ts">
definePageMeta({
    middleware: ["user-only"],
});

const route = useRoute();
const name = route.params.name;

const { data } = useAsyncData("productId", async () => {
    const { data } = await useFetch<any>(`/api/products/${name}`); // TODO: response type
    return data.value;
});

useHead({
    title: data.value.title,
    meta: [
        {
            hid: "description",
            name: "description",
            content: data.value.description,
        },
    ],
});
</script>

<template>
    <div>
        <NuxtLayout name="custom" v-if="true">
            <div class="max-w-2xl overflow-hidden bg-white shadow sm:rounded-lg m-auto">
                <div class="px-4 py-5 sm:px-6">
                    <h3 class="text-lg font-medium leading-6 text-gray-900">Product Page - {{ data.title }}</h3>
                </div>
                <div class="border-t border-gray-200">
                    <dl>
                        <div class="px-4 py-5 bg-gray-50 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                            <dt class="text-sm font-medium text-gray-500">Title</dt>
                            <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                                {{ data.title }}
                            </dd>
                        </div>
                        <div class="px-4 py-5 bg-white sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                            <dt class="text-sm font-medium text-gray-500">Description</dt>
                            <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                                {{ data.description }}
                            </dd>
                        </div>
                        <div class="px-4 py-5 bg-gray-50 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                            <dt class="text-sm font-medium text-gray-500">Price</dt>
                            <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">$ {{ data.price }}</dd>
                        </div>
                        <div class="px-4 py-5 bg-white sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                            <dt class="text-sm font-medium text-gray-500">Brand</dt>
                            <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                                {{ data.brand }}
                            </dd>
                        </div>
                        <div class="px-4 py-5 bg-gray-50 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
                            <dt class="text-sm font-medium text-gray-500">Category</dt>
                            <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                                {{ data.category }}
                            </dd>
                        </div>
                    </dl>
                </div>
            </div>
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
