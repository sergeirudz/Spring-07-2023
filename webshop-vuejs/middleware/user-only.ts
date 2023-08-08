import { useUserStore } from 'store/store.account';

export default defineNuxtRouteMiddleware(async () => {
  const userStore = useUserStore();

  // if (userStore.isLoggedIn === false) {
  //     if (process.server) return navigateTo("/");

  //     return abortNavigation();
  // }
});
