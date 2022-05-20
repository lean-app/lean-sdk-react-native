import LeanSdk

@objc(LeanSdkViewManager)
class LeanSdkViewManager: RCTViewManager {

  override func view() -> (LeanSdkView) {
    return LeanSdkView()
  }
}

class LeanSdkView : UIView {

  @objc var userToken: String?
  @objc var options: [String: String]? = nil
  @objc var theme: [String: Any]? {
      didSet {
          
          sdkTheme = Theme(color: (theme?["color"] as? Dictionary<String, String>), fontFamily: (theme?["fontFamily"] as? String), fontWeight: (theme?["fontWeight"] as? Dictionary<String, String>))
      }
  }
  var lean: Lean? = nil
  var sdkTheme: Theme? = nil

  override func layoutSubviews() {
      super.layoutSubviews()
      
      lean = Lean(parentView: self, userToken: self.userToken!, theme: self.sdkTheme, options: self.options)
  }
}
