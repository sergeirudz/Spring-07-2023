<script setup lang="ts">
const { isDarkMode, toggleDarkMode } = useDarkMode();
</script>

<template>
  <nav class="">
    <div class="">
      <NuxtLink class="" to="/">Webshop</NuxtLink>
      <div class="" id="">
        <ul class="">
          <li class="">
            <NuxtLink to="/" class="" activeClass="">Home</NuxtLink>
          </li>
          <li class="">
            <NuxtLink to="/products" class="" activeClass="">Products</NuxtLink>
          </li>
          <li class="">
            <NuxtLink to="/login" class="" activeClass="">Login</NuxtLink>
          </li>
          <li class="">
            <NuxtLink to="/register" class="" activeClass="">Register</NuxtLink>
          </li>
        </ul>
        <div>
          <input
            type="checkbox"
            v-model="isDarkMode"
            @click="toggleDarkMode()"
            id="toggleDarkMode"
          />
          <label for="toggleDarkMode">Toggle Dark Mode</label>
        </div>
      </div>
    </div>
  </nav>
</template>

<style scoped></style>
