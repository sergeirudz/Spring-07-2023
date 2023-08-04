<template>
  <div>
    <Html :lang="dynamic > 50 ? 'en-GB' : 'en-US'">
      <Head>
        <Title>Webshop </Title>
        <Meta name="description" content="My page is cool" />
        <!-- <Link
          rel="preload"
          href="https://www.iconpacks.net/"
          as="script"
        /> -->
      </Head>
    </Html>
    <div class="container">
      <h1>Webshop</h1>
      <NuxtLink to="/products">View Products</NuxtLink>
    </div>
  </div>
</template>

<style scoped>
.container {
  text-align: center;
  margin-top: 5rem;
}
</style>
