import React, { useState } from 'react'
import {StyleSheet, TextInput, Text, View} from 'react-native';

const Index = () => {
  const [query, setText] = useState('');
  const [ displayText, setDisplayText] = useState('');

  const handleDisplayText = () => { //For displaying the text
    setDisplayText(query);
    setText('');
  }

  return (

      <View style={styles.view}>
        <Text style = {styles.text}>Glutten</Text>
        <TextInput
          style={styles.input}
          onChangeText={setText}
          value={query}
          placeholder="Enter a Product"
          onSubmitEditing={handleDisplayText}
        />

        <Text>You Typed: { query }</Text>

      </View>
  );
};

const styles = StyleSheet.create({
  input: {
    height: 40,
    margin: 12,
    borderWidth: 1,
    padding: 10,
  },

  text: {
    fontSize: 50,
    alignItems: 'center',
  },

  view: {
    flex: 1, 
    backgroundColor: '#c9f5e4',
    alignItems: 'center',
  }
});

export default Index;
