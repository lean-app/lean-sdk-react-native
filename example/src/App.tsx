import * as React from 'react';

import { ScrollView, StyleSheet, View } from 'react-native';
import { LeanSdkView } from 'react-native-lean-sdk';

export default function App() {
  return (
    <ScrollView style={styles.container}>
      <View style={styles.box} />
      <View style={styles.box} />
      <LeanSdkView
        userToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImN1c3RvbWVyX3RialpvcjBOakwweVdINjI1X2NLViIsImVtYWlsIjoidGltK2N1c3RvbWVyNzMwQHdpdGhsZWFuLmNvbSIsImludGVyZmFjZUlkIjoiaW50ZXJmYWNlX09MVGFmTlY0QVM4NHNQNm1uQzFQMSIsInN0YXR1cyI6IkNPTkZJUk1FRCIsImlhdCI6MTY1MjgzNTcxNCwiZXhwIjoxNjUzNDQwNTE0fQ.EmMWNgI8IkvQIIa1VxGJeCUnLlx9HfukF6Kt8huQty4"
        style={styles.box}
        options={{ environment: 'STAGING' }}
        eventCallback={(data) => console.log(data)}
        // theme={{
        //   color: { primary: 'red', textPrimary: 'red', textSecondary: 'green' },
        // }}
      />
      <View style={styles.box} />
      <View style={styles.box} />
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  box: {
    height: 240,
  },
});
