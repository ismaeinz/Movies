# 🎬 Movie App

A modern Android Movie App built using **Kotlin**, **Jetpack Compose**, and **MVVM architecture**.
This app displays a list of movies fetched from a remote API, with a clean and intuitive UI.

---

## ✨ Features

- 🧱 MVVM Architecture
- 🎨 Jetpack Compose UI
- 🌐 Retrofit for API calls
- 📦 Hilt for Dependency Injection
- 🖼️ Coil for image loading
- 🔄 Pagination (optional)
- 💡 Clean and modular codebase

---

## 🖼️ Screenshots

| Home Screen                          | Movie Details                              |
|--------------------------------------|--------------------------------------------|
| ![Home](screenshots/home_screen.png) | ![Details](screenshots/details_screen.png) |

> 📁 _Make sure to place screenshots in a folder named `screenshots/` inside your repo._

---

## 📁 Architecture

This app uses **Model-View-ViewModel (MVVM)** architecture:

```
com.example.movieapp
│
├── data
│   ├── model          # Data classes (e.g., Movie.kt)
│   ├── remote         # Retrofit interfaces and network models
│   └── repository     # Repository pattern for data access
│
├── di                 # Hilt modules for dependency injection
│
├── presentation
│   ├── components     # Reusable Compose UI elements
│   ├── screens        # UI screens (HomeScreen, DetailsScreen)
│   ├── state          # UI state holders (e.g., MovieListState)
│   └── viewmodel      # ViewModels for business logic
│
└── utils              # Constants, helpers, extensions
```

---

## 🛠️ Built With

- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Retrofit](https://square.github.io/retrofit/)
- [Coil](https://coil-kt.github.io/coil/)
- [Coroutines & Flow](https://developer.android.com/kotlin/flow)

---

## 🚀 Getting Started

### 1. Clone the repo

```bash
git clone https://github.com/your-username/movie-app.git
cd movie-app
```

### 2. Open in Android Studio

Make sure you have the latest version of Android Studio with Kotlin + Jetpack Compose support.

---

## 🔑 API Key

This app requires an API key (e.g., from [TMDb](https://www.themoviedb.org/)).

Add your API key to `local.properties`:

```
API_KEY=your_api_key_here
```

Or if your key is hardcoded (not recommended), add it in a constants file like:

```kotlin
const val API_KEY = "your_api_key_here"
```

---

## 🧪 Testing

- ViewModels tested using `JUnit` and `Turbine`
- Repository tested using fake implementations or mocked APIs

(You can expand this section if you have actual test cases)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙌 Acknowledgments

- [TMDb API](https://developers.themoviedb.org/)
- Android Developers
- Jetpack Compose Team

---

> Made with ❤️ by [Ismaein]