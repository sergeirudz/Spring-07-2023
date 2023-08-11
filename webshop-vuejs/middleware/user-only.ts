import { useUserStore } from "store/store.user";

export default defineNuxtRouteMiddleware(async () => {
    const userStore = useUserStore();

    // if (userStore.isLoggedIn === false) {
    //     if (process.server) return navigateTo("/");

    //     return abortNavigation();
    // }
});
