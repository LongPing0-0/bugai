<template>
  <view>
    <form @submit="submit">
      <textarea v-model="message"></textarea>
      <button type="submit">提交</button>
    </form>
  </view>
</template>

<script>
export default {
  data() {
    return {
      message: "",
    };
  },
  methods: {
    submit() {
      let messages = uni.getStorageSync("messages") || [];
      messages.push(this.message);
	  console.log(messages)
      uni.setStorageSync("messages", messages);
      uni.navigateBack();
    },
  },
};
</script>
