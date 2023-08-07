import { useUserStore } from "store/store.account";

export default defineNuxtRouteMiddleware(async () => {
    const userStore = useUserStore();

    if (userStore.isLoggedIn === true) {
        if (process.server) return navigateTo("/");

        return abortNavigation();
    }
});
