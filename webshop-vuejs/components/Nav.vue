<script setup lang="ts">
const { isDarkMode, toggleDarkMode } = useDarkMode();

const isMenuOpen = ref(false);
const isMobileMenuOpen = ref(false);

const toggleMenu = () => {
  isMenuOpen.value = !isMenuOpen.value;
};
const toggleMobileMenu = () => {
  isMobileMenuOpen.value = !isMobileMenuOpen.value;
};
</script>

<template>
  <div>
    <nav class="bg-white dark:bg-gray-800 shadow">
      <div class="px-8 mx-auto max-w-7xl">
        <div class="flex items-center justify-between h-16">
          <div class="flex items-center">
            <div class="hidden md:block">
              <div class="flex items-baseline ml-10 space-x-4">
                <NuxtLink
                  class="text-gray-300 hover:text-gray-800 dark:hover:text-white px-3 py-2 rounded-md text-sm font-medium"
                  to="/"
                >
                  Home
                </NuxtLink>
                <NuxtLink
                  class="text-gray-800 dark:text-white hover:text-gray-800 dark:hover:text-white px-3 py-2 rounded-md text-sm font-medium"
                  to="/products"
                >
                  Products
                </NuxtLink>
                <NuxtLink
                  class="text-gray-300 hover:text-gray-800 dark:hover:text-white px-3 py-2 rounded-md text-sm font-medium"
                  to="/cart"
                >
                  Cart
                </NuxtLink>
              </div>
            </div>
          </div>
          <div class="hidden md:block">
            <div class="flex items-center ml-4 md:ml-6">
              <div class="relative ml-3">
                <div class="relative inline-block text-left">
                  <div>
                    <button
                      @click="toggleMenu"
                      type="button"
                      class="flex items-center justify-center w-full rounded-md px-4 py-2 text-sm font-medium text-gray-700 dark:text-gray-50 hover:bg-gray-50 dark:hover:bg-gray-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-100 focus:ring-gray-500"
                      id="options-menu"
                    >
                      <svg
                        width="20"
                        fill="currentColor"
                        height="20"
                        class="text-white"
                        viewBox="0 0 1792 1792"
                        xmlns="http://www.w3.org/2000/svg"
                      >
                        <path
                          d="M1523 1339q-22-155-87.5-257.5t-184.5-118.5q-67 74-159.5 115.5t-195.5 41.5-195.5-41.5-159.5-115.5q-119 16-184.5 118.5t-87.5 257.5q106 150 271 237.5t356 87.5 356-87.5 271-237.5zm-243-699q0-159-112.5-271.5t-271.5-112.5-271.5 112.5-112.5 271.5 112.5 271.5 271.5 112.5 271.5-112.5 112.5-271.5zm512 256q0 182-71 347.5t-190.5 286-285.5 191.5-349 71q-182 0-348-71t-286-191-191-286-71-348 71-348 191-286 286-191 348-71 348 71 286 191 191 286 71 348z"
                        ></path>
                      </svg>
                    </button>
                  </div>
                  <div
                    v-if="isMenuOpen"
                    id="profile-menu"
                    class="absolute right-0 w-56 mt-2 origin-top-right bg-white rounded-md shadow-lg dark:bg-gray-800 ring-1 ring-black ring-opacity-5"
                  >
                    <div
                      class="py-1"
                      role="menu"
                      aria-orientation="vertical"
                      aria-labelledby="options-menu"
                    >
                      <span
                        class="cursor-pointer block block px-4 py-2 text-md text-gray-700 hover:bg-gray-100 hover:text-gray-900 dark:text-gray-100 dark:hover:text-white dark:hover:bg-gray-600"
                        role="menuitem"
                      >
                        <span class="flex flex-col">
                          <div class="">
                            <div
                              class="relative inline-block w-10 mr-2 align-middle justify-center select-none"
                            >
                              <input
                                v-model="isDarkMode"
                                @click="toggleDarkMode()"
                                id="toggleDarkMode"
                                type="checkbox"
                                name="toggle"
                                class="checked:bg-black outline-none focus:outline-none right-4 checked:right-0 duration-200 ease-in absolute block w-6 h-6 rounded-full bg-white border-4 appearance-none cursor-pointer"
                              />
                              <label
                                for="toggleDarkMode"
                                class="block h-6 overflow-hidden bg-gray-300 rounded-full cursor-pointer"
                              >
                              </label>
                            </div>
                            <span class="font-medium text-gray-400">
                              Black
                            </span>
                          </div>
                        </span>
                      </span>
                      <NuxtLink
                        to="/profile"
                        class="block block px-4 py-2 text-md text-gray-700 hover:bg-gray-100 hover:text-gray-900 dark:text-gray-100 dark:hover:text-white dark:hover:bg-gray-600"
                        role="menuitem"
                      >
                        <span class="flex flex-col">
                          <span> Profile </span>
                        </span>
                      </NuxtLink>
                      <span
                        class="cursor-pointer block block px-4 py-2 text-md text-gray-700 hover:bg-gray-100 hover:text-gray-900 dark:text-gray-100 dark:hover:text-white dark:hover:bg-gray-600"
                        role="menuitem"
                      >
                        <span class="flex flex-col">
                          <span> Logout </span>
                        </span>
                      </span>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="flex -mr-2 md:hidden">
            <button
              @click="toggleMobileMenu"
              class="text-gray-800 dark:text-white hover:text-gray-300 inline-flex items-center justify-center p-2 rounded-md focus:outline-none"
            >
              <svg
                width="20"
                height="20"
                fill="currentColor"
                class="w-8 h-8"
                viewBox="0 0 1792 1792"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M1664 1344v128q0 26-19 45t-45 19h-1408q-26 0-45-19t-19-45v-128q0-26 19-45t45-19h1408q26 0 45 19t19 45zm0-512v128q0 26-19 45t-45 19h-1408q-26 0-45-19t-19-45v-128q0-26 19-45t45-19h1408q26 0 45 19t19 45zm0-512v128q0 26-19 45t-45 19h-1408q-26 0-45-19t-19-45v-128q0-26 19-45t45-19h1408q26 0 45 19t19 45z"
                ></path>
              </svg>
            </button>
          </div>
        </div>
      </div>
      <div v-if="isMobileMenuOpen" class="md:hidden flex justify-between w-100">
        <div class="px-2 pt-2 pb-3 space-y-1 sm:px-3">
          <NuxtLink
            class="text-gray-300 hover:text-gray-800 dark:hover:text-white block px-3 py-2 rounded-md text-base font-medium"
            to="/"
            role="menuitem"
          >
            Home
          </NuxtLink>
          <NuxtLink
            class="text-gray-800 dark:text-white block px-3 py-2 rounded-md text-base font-medium"
            to="/products"
            role="menuitem"
          >
            Products
          </NuxtLink>
          <NuxtLink
            class="text-gray-300 hover:text-gray-800 dark:hover:text-white block px-3 py-2 rounded-md text-base font-medium"
            to="/cart"
            role="menuitem"
          >
            Cart
          </NuxtLink>
        </div>
        <div class="px-2 pt-2 pb-3 space-y-1 sm:px-3">
          <span
            class="text-gray-300 hover:text-gray-800 dark:hover:text-white block px-3 py-2 rounded-md text-base font-medium"
            role="menuitem"
          >
            <span class="flex flex-col">
              <div class="">
                <div
                  class="relative inline-block w-10 mr-2 align-middle justify-center select-none"
                >
                  <input
                    v-model="isDarkMode"
                    @click="toggleDarkMode()"
                    id="toggleDarkMode"
                    type="checkbox"
                    name="toggle"
                    class="checked:bg-black outline-none focus:outline-none right-4 checked:right-0 duration-200 ease-in absolute block w-6 h-6 rounded-full bg-white border-4 appearance-none cursor-pointer"
                  />
                  <label
                    for="toggleDarkMode"
                    class="block h-6 overflow-hidden bg-gray-300 rounded-full cursor-pointer"
                  >
                  </label>
                </div>
                <span class="font-medium text-gray-400"> Black </span>
              </div>
            </span>
          </span>
          <NuxtLink
            class="text-gray-800 dark:text-white block px-3 py-2 rounded-md text-base font-medium"
            to="/profile"
            role="menuitem"
          >
            Profile
          </NuxtLink>
          <span
            class="cursor-pointer text-gray-300 hover:text-gray-800 dark:hover:text-white block px-3 py-2 rounded-md text-base font-medium"
            role="menuitem"
          >
            Logout
          </span>
        </div>
      </div>
    </nav>
  </div>
</template>

<style scoped></style>

<!-- 

          <input
            type="checkbox"
            v-model="isDarkMode"
            @click="toggleDarkMode()"
            id="toggleDarkMode"
          />
          <label for="toggleDarkMode">Toggle Dark Mode</label>
 -->
