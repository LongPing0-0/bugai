<template>
  <div class="container">
    <img class="image1" :src="image1Src">
  </div>
</template>

<script>
export default {
  data() {
    return {
      image1Src: './static/imgs/jiaoliuluntanfengmian.png',
      showImage1: true
    }
  }
}
</script>

<style scoped>
.container {
  position: relative;
}

.image1 {
  position: relative;
  z-index: 1;
  max-width: 100%;
}

.close-button {
  position: absolute;
  top: 0;
  right: 0;
  z-index: 2;
  cursor: pointer;
  background-color: #fff;
  color: #000;
  border: 1px solid #000;
  padding: 5px;
  width: 60px; /* 设置关闭按钮宽度为 30 像素 */
  height: 45px; /* 设置关闭按钮高度为 30 像素 */
  line-height: 30px; /* 设置关闭按钮内部内容的行高为 30 像素，使其垂直居中 */
  text-align: center; /* 设置关闭按钮内部内容居中对齐 */
}

.image3 {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 3;
  cursor: pointer;
  max-width: 100%;
}
</style>
