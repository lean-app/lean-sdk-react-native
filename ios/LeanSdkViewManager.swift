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
  var lean: Lean? = nil

  override func layoutSubviews() {
      super.layoutSubviews()
      lean = Lean(parentView: self, userToken: self.userToken!, options: self.options)
  }
}
