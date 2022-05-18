import LeanSdk

@objc(LeanSdkViewManager)
class LeanSdkViewManager: RCTViewManager {

  override func view() -> (LeanSdkView) {
    return LeanSdkView()
  }
}

class LeanSdkView : UIView {

  @objc var token: String?
  @objc var options: [String: String]? = nil
  var lean: Lean? = nil

  override func layoutSubviews() {
      super.layoutSubviews()
      lean = Lean(parentView: self, userToken: self.token!, options: self.options)
  }
}
