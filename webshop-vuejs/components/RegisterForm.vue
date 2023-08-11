<template lang="">
    <div class="flex flex-col w-full max-w-md py-8 bg-white rounded-lg shadow dark:bg-gray-800 sm:px-6 md:px-8 lg:px-4">
        <div class="self-center mb-6 text-xl font-light text-gray-600 sm:text-2xl dark:text-white">
            Create a new account
        </div>
        <div class="mt-8">
            <form action="#" autoComplete="off" @submit.prevent="handleSubmit">
                <div class="flex flex-row gap-2">
                    <div>
                        <!-- EMAIL -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <span
                                    class="rounded-l-md inline-flex items-center px-3 border-t bg-white border-l border-b border-gray-300 text-gray-500 shadow-sm text-sm"
                                >
                                    <svg
                                        width="15"
                                        height="15"
                                        fill="currentColor"
                                        viewBox="0 0 1792 1792"
                                        xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                            d="M1792 710v794q0 66-47 113t-113 47h-1472q-66 0-113-47t-47-113v-794q44 49 101 87 362 246 497 345 57 42 92.5 65.5t94.5 48 110 24.5h2q51 0 110-24.5t94.5-48 92.5-65.5q170-123 498-345 57-39 100-87zm0-294q0 79-49 151t-122 123q-376 261-468 325-10 7-42.5 30.5t-54 38-52 32.5-57.5 27-50 9h-2q-23 0-50-9t-57.5-27-52-32.5-54-38-42.5-30.5q-91-64-262-182.5t-205-142.5q-62-42-117-115.5t-55-136.5q0-78 41.5-130t118.5-52h1472q65 0 112.5 47t47.5 113z"
                                        ></path>
                                    </svg>
                                </span>
                                <input
                                    v-model="form.data.contactData.email"
                                    type="text"
                                    id="email"
                                    class="rounded-r-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="Your email"
                                />
                            </div>
                        </div>
                        <!-- PASSWORD -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <span
                                    class="rounded-l-md inline-flex items-center px-3 border-t bg-white border-l border-b border-gray-300 text-gray-500 shadow-sm text-sm"
                                >
                                    <svg
                                        width="15"
                                        height="15"
                                        fill="currentColor"
                                        viewBox="0 0 1792 1792"
                                        xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                            d="M1376 768q40 0 68 28t28 68v576q0 40-28 68t-68 28h-960q-40 0-68-28t-28-68v-576q0-40 28-68t68-28h32v-320q0-185 131.5-316.5t316.5-131.5 316.5 131.5 131.5 316.5q0 26-19 45t-45 19h-64q-26 0-45-19t-19-45q0-106-75-181t-181-75-181 75-75 181v320h736z"
                                        ></path>
                                    </svg>
                                </span>
                                <input
                                    v-model="form.data.password"
                                    type="password"
                                    id="password"
                                    class="rounded-r-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="Your password"
                                />
                            </div>
                        </div>
                        <!-- PASSWORD -->
                        <div class="flex flex-col mb-6">
                            <div class="flex relative">
                                <span
                                    class="rounded-l-md inline-flex items-center px-3 border-t bg-white border-l border-b border-gray-300 text-gray-500 shadow-sm text-sm"
                                >
                                    <svg
                                        width="15"
                                        height="15"
                                        fill="currentColor"
                                        viewBox="0 0 1792 1792"
                                        xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                            d="M1376 768q40 0 68 28t28 68v576q0 40-28 68t-68 28h-960q-40 0-68-28t-28-68v-576q0-40 28-68t68-28h32v-320q0-185 131.5-316.5t316.5-131.5 316.5 131.5 131.5 316.5q0 26-19 45t-45 19h-64q-26 0-45-19t-19-45q0-106-75-181t-181-75-181 75-75 181v320h736z"
                                        ></path>
                                    </svg>
                                </span>
                                <input
                                    v-model="form.data.passwordConfirm"
                                    type="password"
                                    id="passwordConfirm"
                                    class="rounded-r-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="Confirm password"
                                />
                            </div>
                        </div>
                    </div>

                    <div>
                        <!-- FIRST NAME -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <input
                                    v-model="form.data.firstName"
                                    type="text"
                                    id="firstName"
                                    class="rounded-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="First name"
                                />
                            </div>
                        </div>

                        <!-- LAST NAME -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <input
                                    v-model="form.data.lastName"
                                    type="text"
                                    id="lastName"
                                    class="rounded-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="Last name"
                                />
                            </div>
                        </div>

                        <!-- PERSONAL CODE -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <input
                                    v-model="form.data.personalCode"
                                    type="text"
                                    id="personalCode"
                                    class="rounded-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="Personal code"
                                />
                            </div>
                        </div>

                        <!-- PHONE -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <input
                                    v-model="form.data.contactData.phone"
                                    type="text"
                                    id="phone"
                                    class="rounded-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="Phone"
                                />
                            </div>
                        </div>

                        <!-- COUNTRY -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <input
                                    v-model="form.data.contactData.address.country"
                                    type="text"
                                    id="country"
                                    class="rounded-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="Country"
                                />
                            </div>
                        </div>

                        <!-- COUNTY -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <input
                                    v-model="form.data.contactData.address.county"
                                    type="text"
                                    id="county"
                                    class="rounded-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="County"
                                />
                            </div>
                        </div>

                        <!-- STREET -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <input
                                    v-model="form.data.contactData.address.street"
                                    type="text"
                                    id="street"
                                    class="rounded-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="Street"
                                />
                            </div>
                        </div>

                        <!-- NUMBER -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <input
                                    v-model="form.data.contactData.address.number"
                                    type="text"
                                    id="number"
                                    class="rounded-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="Number"
                                />
                            </div>
                        </div>

                        <!-- POSTAL INDEX -->
                        <div class="flex flex-col mb-2">
                            <div class="flex relative">
                                <input
                                    v-model="form.data.contactData.address.postalIndex"
                                    type="text"
                                    id="postalIndex"
                                    class="rounded-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent"
                                    placeholder="Postal Index"
                                />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="flex w-full">
                    <button
                        type="submit"
                        class="mt-3 py-2 px-4 bg-purple-600 hover:bg-purple-700 focus:ring-purple-500 focus:ring-offset-purple-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2 rounded-lg"
                    >
                        Create Account
                    </button>
                    <button
                        @click="fillForm"
                        type="submit"
                        class="mt-3 py-2 px-4 bg-purple-600 hover:bg-purple-700 focus:ring-purple-500 focus:ring-offset-purple-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2 rounded-lg"
                    >
                        Fill Form
                    </button>
                </div>
            </form>
        </div>
        <div class="flex items-center justify-center mt-6">
            <NuxtLink
                to="/login"
                class="inline-flex items-center text-xs font-thin text-center text-gray-500 hover:text-gray-700 dark:text-gray-100 dark:hover:text-white"
            >
                Already have an account? Sign in!
            </NuxtLink>
        </div>
    </div>
</template>
<script setup lang="ts">
import { Register } from "server/models/register";
import { useUserStore } from "store/store.user";
const userStore = useUserStore();

interface Form {
    data: Register;
    error: string;
    pending: boolean;
}

const form: Form = reactive({
    data: {
        personalCode: "",
        firstName: "",
        lastName: "",
        password: "",
        passwordConfirm: "",
        contactData: {
            email: "",
            phone: "",
            address: {
                country: "",
                county: "",
                street: " tee",
                number: "",
                postalIndex: "",
            },
        },
    },
    error: "",
    pending: false,
});

const fillForm = () => {
    form.data.personalCode = "1";
    form.data.firstName = "John";
    form.data.lastName = "Doe";
    form.data.password = "1";
    form.data.passwordConfirm = "1";
    form.data.contactData.email = "1@1.com";
    form.data.contactData.phone = "5555555";
    form.data.contactData.address.country = "Estonia";
    form.data.contactData.address.county = "Harju";
    form.data.contactData.address.street = "Lennuvälja tee";
    form.data.contactData.address.number = "1";
    form.data.contactData.address.postalIndex = "123456";
};

const handleSubmit = async () => {
    try {
        form.pending = true;
        await userStore.register(form.data);
        await navigateTo("/");
    } catch (error) {
        console.error(error);
    } finally {
        form.pending = false;
    }
};
</script>
<style lang=""></style>
