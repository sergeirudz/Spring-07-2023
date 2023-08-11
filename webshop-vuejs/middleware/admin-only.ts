import { useUserStore } from "store/store.user";

export default defineNuxtRouteMiddleware(async () => {
    const userStore = useUserStore();

    if (userStore.isAdmin === false) return navigateTo("/");

    if (userStore.isLoggedIn === true) {
        if (process.server) return navigateTo("/");

        return abortNavigation();
    }
});
