# Gender-Checker
Gender Checker app built using Kotlin, MVVM, Genderize.io API

Enter a name and the app will guess the gender 🤩

## Highligts:

- API : [Genderize.io](https://genderize.io)
- Architecture: MVVM
- DI : Dagger-Hilt

## About Genderize.io

Genderize.io is a simple API to predict the gender of a person given their name

The API is free for up to 1000 names/day. No sign up or API key needed.

The request will render a response like the following:
```json
{
  "name": "peter",
  "gender": "male",
  "probability": 0.99,
  "count": 165452
}
```
The probability indicates the certainty of the assigned gender. Basically the ratio of male to females. The count represents the number of data rows examined in order to calculate the response.

For more information, visit [Genderize.io](https://genderize.io)

<img src="https://github.com/jaikeerthick/Gender-Checker/blob/master/app/src/main/res/drawable/app_screenshot.png">
