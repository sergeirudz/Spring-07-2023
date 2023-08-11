// old name ;01.auth.global.ts

import { useUserStore } from "store/store.user";

export default defineNuxtRouteMiddleware((to, from) => {
    // const userStore = useUserStore();
    // if (userStore.isLoggedIn === false) {
    //   return navigateTo('/login');
    // }
    // \
    // console.log('userStore.isLoggedIn', userStore.isLoggedIn);

    // if (userStore.isLoggedIn === false && to.path === '/login') {
    //   return navigateTo('/');
    // }

    // return navigateTo(`/login`);

    // to.path === '/login' && navigateTo('/');

    console.log("to.path", to.path);
    if (to.path === "/login") {
        return navigateTo("/");
    }

    // skip middleware on server
    if (process.server) {
        return navigateTo("/login");
    }
    // skip middleware on client side entirely
    if (process.client) {
        return navigateTo("/login");
    }
    // or only skip middleware on initial client load
    const nuxtApp = useNuxtApp();
    if (process.client && nuxtApp.isHydrating && nuxtApp.payload.serverRendered) return;
});
